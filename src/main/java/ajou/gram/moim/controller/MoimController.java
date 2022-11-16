package ajou.gram.moim.controller;

import ajou.gram.moim.domain.Moim;
import ajou.gram.moim.domain.MoimMember;
import ajou.gram.moim.dto.CreateMoimDto;
import ajou.gram.moim.dto.JoinDto;
import ajou.gram.moim.dto.JoinMoimDto;
import ajou.gram.moim.service.MoimService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Tag(name = "moim", description = "모임방 관련 API")
@RestController
@RequestMapping("/moim")
@RequiredArgsConstructor
public class MoimController {

    private final MoimService moimService;

    @Operation(summary = "GET() /moim", description = "모임방 조회 & 검색")
    @Parameters({
            @Parameter(name = "categoryId", description = "카테고리 상위/하위 아이디", example = "1"),
            @Parameter(name = "sido", description = "시/도", example = "서울특별시"),
            @Parameter(name = "sigungu", description = "시/군/구", example = "강남구"),
            @Parameter(name = "dong", description = "동/읍/면", example = "삼성동"),
            @Parameter(name = "title", description = "모임방 이름", example = "즐거운 모임")
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "모임 조회 성공", content = @Content(schema = @Schema(implementation = Moim.class)))
    })
    @GetMapping("")
    public ResponseEntity<List<Moim>> getMoims(@RequestParam(value = "categoryId", required = false, defaultValue = "0") int categoryId,
                                              @RequestParam(value = "sido", required = false) String sido,
                                              @RequestParam(value = "sigungu", required = false) String sigungu,
                                              @RequestParam(value = "dong", required = false) String dong,
                                              @RequestParam(value = "title", required = false) String title) {
        return ResponseEntity.ok().body(moimService.getMoims(categoryId, sido, sigungu, dong, title));
    }

    @Operation(summary = "POST() /moim", description = "모임방 개설")
    @Parameters({
            @Parameter(name = "userId", description = "모임방 개설자 아이디(필수)", example = "2501213540"),
            @Parameter(name = "categoryId", description = "카테고리 하위 아이디(필수)", example = "1"),
            @Parameter(name = "title", description = "모임방 이름(필수)", example = "즐거운 모임"),
            @Parameter(name = "content", description = "모임방 설명", example = "친목 모임 입니다."),
            @Parameter(name = "sido", description = "시/도(필수)", example = "서울특별시"),
            @Parameter(name = "sigungu", description = "시/군/구(필수)", example = "강남시"),
            @Parameter(name = "dong", description = "동/읍/면(필수)", example = "삼성동"),
            @Parameter(name = "isPublish", description = "모임방 공개 여부(필수)", example = "Y / N"),
            @Parameter(name = "isFreeEnter", description = "자유 가입 여부(필수)", example = "Y / N"),
            @Parameter(name = "maxMember", description = "모임방 최대 인원 수(필수)", example = "30")
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "모임방 개설 성공", content = @Content(schema = @Schema(implementation = CreateMoimDto.class))),
            @ApiResponse(responseCode = "400", description = "모임방 개설 실패")
    })
    @PostMapping("")
    public ResponseEntity<?> addMoim(@RequestBody CreateMoimDto createMoimDto) {
        try {
            moimService.addMoim(createMoimDto);
            return ResponseEntity.ok().body(createMoimDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("모임방 개설에 실패하였습니다.");
        }
    }

    @Operation(summary = "GET() /moim/{id}", description = "모임방 상세 조회")
    @Parameters({
            @Parameter(name = "id", description = "모임방 아이디(필수)", example = "1")
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "모임방 상제 조회 성공", content = @Content(schema = @Schema(implementation = Moim.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Moim>> getMoim(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(moimService.getMoim(id));
    }

    @Operation(summary = "POST() /moim/free", description = "모임방 자유 가입")
    @Parameters({
            @Parameter(name = "id", description = "모임방 아이디(필수)", example = "1"),
            @Parameter(name = "userId", description = "가입하고자 하는 유저 아이디(필수)", example = "2501238503")
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "자유 가입 성공", content = @Content(schema = @Schema(implementation = MoimMember.class))),
            @ApiResponse(responseCode = "400", description = "자유 가입 실패")
    })
    @PostMapping("free")
    public ResponseEntity<?> moimJoin(@RequestBody MoimMember moimMember) {
        try {
            moimService.moimJoin(moimMember);
            return ResponseEntity.ok().body(moimMember);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("가입에 실패하였습니다.");
        }
    }

    @Operation(summary = "POST() /moim/pass", description = "모임방 가입 신청")
    @Parameters({
            @Parameter(name = "moimId", description = "모임방 아이디(필수)", example = "1"),
            @Parameter(name = "userId", description = "가입하고자 하는 유저 아이디(필수)", example = "2501238503"),
            @Parameter(name = "message", description = "가입 신청 메세지", example = "안녕하세요, 모임 가입하고 싶어요.")
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "가입 신청 성공", content = @Content(schema = @Schema(implementation = JoinMoimDto.class))),
            @ApiResponse(responseCode = "400", description = "가입 신청 실패")
    })
    @PostMapping("pass")
    public ResponseEntity<?> moimJoinMessage(@RequestBody JoinMoimDto joinMoimDto) {
        try {
            moimService.moimJoinMessage(joinMoimDto);
            return ResponseEntity.ok().body(joinMoimDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("가입 신청을 실패하였습니다.");
        }
    }
}

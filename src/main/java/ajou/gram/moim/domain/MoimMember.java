package ajou.gram.moim.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "moimMember")
@IdClass(MoimMemberPK.class)
public class MoimMember {

    @Id @Column(name = "moim_id")
    private long moimId;
    @Id @Column(name = "user_id")
    private long userId;
    private Date registerDate;
    private short level;
}
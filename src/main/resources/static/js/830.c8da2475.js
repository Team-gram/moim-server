"use strict";(self["webpackChunkgramvue2"]=self["webpackChunkgramvue2"]||[]).push([[830],{7830:function(e,t,n){n.r(t);var i=n(8480),l={props:["creator","index","cellData","constructedEvents","temporaryEvent"],inject:["kalendar_options"],components:{KalendarEvent:function(){return n.e(545).then(n.bind(n,8545))}},computed:{cell_events:function(){var e=[];return this.completed_events&&(e=e.concat(this.completed_events)),this.being_created&&(e=e.concat(this.being_created)),e},completed_events:function(){return this.constructedEvents&&this.constructedEvents.hasOwnProperty(this.cellData.value)&&this.constructedEvents[this.cellData.value]},being_created:function(){return this.temporaryEvent&&this.temporaryEvent.start.value===this.cellData.value&&this.temporaryEvent},overlappingEvents:function(){var e=this;return!this.constructedEvents||this.cell_events.length<1?[]:Object.values(this.constructedEvents).flat().filter((function(t){var n=new Date(e.cellData.value),i=new Date(t.start.value),l=new Date(t.end.value);return i<n&&l>n}))},overlapValue:function(){var e=this.overlappingEvents.length;return e>2?2:e},selected:function(){return this.cell_events&&this.cell_events.length>0},hasPopups:function(){return this.selected&&!!this.cell_events.find((function(e){return"popup-initiated"===e.status}))}},methods:{mouseDown:function(){if(this.creator.creating)this.mouseUp();else{var e=this.kalendar_options,t=e.read_only,n=e.overlap,l=e.past_event_creation;if(!t){if(!1===l){var r=(0,i.g)(new Date);if(new Date(r)>new Date(this.cellData.value))return void this.mouseUp()}if(n||!(this.cell_events.length>0)){this.$kalendar.closePopups();var a={creating:!0,original_starting_cell:(0,i.c)(this.cellData),starting_cell:(0,i.c)(this.cellData),current_cell:(0,i.c)(this.cellData),ending_cell:(0,i.c)(this.cellData)};this.$emit("select",a)}}}},mouseMove:function(){var e=this.kalendar_options,t=e.read_only;e.overlap;if(!t&&(!this.creator||this.creator.creating)){var n=this.creator,l=n.starting_cell,r=n.original_starting_cell,a=n.creating,s=this.cellData.index>=l.index&&l.index===r.index;if(a){var o=(0,i.b)((0,i.b)({},this.creator),{},{current_cell:this.cellData,ending_cell:this.cellData,direction:s?"normal":"reverse"});this.$emit("select",o)}}},mouseUp:function(){this.kalendar_options.read_only||this.creator.creating&&this.$emit("initiatePopup")},resetCreator:function(){this.$emit("reset")},isAnHour:function(e){return!!this.kalendar_options.hourlySelection||(e+1)%6===0}}},r=l,a=function(){var e=this,t=e.$createElement,n=e._self._c||t;return e.cellData.visible?n("li",{staticClass:"kalendar-cell",class:{selected:e.selected,"is-an-hour":e.isAnHour(e.index),"has-events":e.cell_events&&e.cell_events.length>0,"being-created":!!e.being_created||e.hasPopups},style:"\n  height: "+e.kalendar_options.cell_height+"px;\n",on:{mouseover:function(t){return t.target!==t.currentTarget?null:e.mouseMove()},mousedown:function(t){return t.target!==t.currentTarget?null:e.mouseDown()},mouseup:function(t){return e.mouseUp()}}},e._l(e.cell_events,(function(t,i){return e.cell_events&&e.cell_events.length?n("KalendarEvent",{key:i,style:"z-index: 10",attrs:{event:t,total:e.cell_events.length,index:i,overlaps:e.overlapValue}}):e._e()})),1):e._e()},s=[],o=function(e){e&&e("data-v-43f6a2ab_0",{source:"li{font-size:13px;position:relative}.created-events{height:100%}ul.building-blocks li{z-index:0;border-bottom:dotted 1px var(--odd-cell-border-color)}ul.building-blocks li.first_of_appointment{z-index:1;opacity:1}ul.building-blocks li.is-an-hour{border-bottom:solid 1px var(--table-cell-border-color)}ul.building-blocks li.has-events{z-index:unset}ul.building-blocks li.being-created{z-index:11}",map:void 0,media:void 0})},c=void 0,u=void 0,d=!1,v=(0,i.d)({render:a,staticRenderFns:s},o,r,c,d,u,!1,i.e,void 0,void 0);t["default"]=v}}]);
//# sourceMappingURL=830.c8da2475.js.map
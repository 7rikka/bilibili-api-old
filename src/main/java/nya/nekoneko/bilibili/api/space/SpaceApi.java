package nya.nekoneko.bilibili.api.space;

import nya.nekoneko.bilibili.model.BiliResult;
import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import nya.nekoneko.bilibili.model.BilibiliRelationStat;
import nya.nekoneko.bilibili.model.BilibiliUser;
import nya.nekoneko.bilibili.util.BiliRequestFactor;
import nya.nekoneko.bilibili.util.Call;
import lombok.extern.slf4j.Slf4j;
import nya.nekoneko.bilibili.config.UrlConfig;
import okhttp3.Request;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class SpaceApi implements ISpace {
    private final BilibiliLoginInfo loginInfo;

    public SpaceApi(BilibiliLoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    /**
     * 获取用户信息（登录状态获取）
     *
     * @param uid
     * @return
     */
    @Override
    public BilibiliUser getUserInfo(int uid) {
        Map<String, String> map = new HashMap<>();
        map.put("mid", String.valueOf(uid));
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.USER_INFO, map)
                .cookie(loginInfo)
                .get()
                .buildRequest();
        BiliResult result = Call.doCall(request);
        if (result.getCode() == 0) {
            return result.getData().toObject(BilibiliUser.class);
//            System.out.println(node.toString());
//            return BilibiliUser.builder()
//                    .uid(node.get("mid").getInt())
//                    .name(node.get("name").getString())
//                    .sex(node.get("sex").getString())
//                    .face(node.get("face").getString())
//                    .face_nft(node.get("face_nft").getInt())
//                    .sign(node.get("sign").getString())
//                    .rank(node.get("rank").getInt())
//                    .level(node.get("level").getInt())
//                    .jointime(node.get("level").getString())
//                    .moral(node.get("moral").getString())
//                    .silence(node.get("silence").getString())
//                    .coins(node.get("silence").getDouble())
//                    .fansBadge(node.get("fans_badge").getBoolean())
//                    .isFollowed(node.get("is_followed").getBoolean())
//                    .topPhoto(node.get("top_photo").getString())
//                    .birthday(node.get("birthday").getString())
//                    .tags(node.get("tags").getString())
//                    .is_senior_member(node.get("is_senior_member").getInt())
//                    .fans_medal(BilibiliFansMedal.builder()
//                            .show(node.get("fans_medal").get("show").getBoolean())
//                            .wear(node.get("fans_medal").get("wear").getBoolean())
//                            .medal(BilibiliMedal.builder()
//                                    .uid(node.get("fans_medal").get("medal").get("uid").getInt())
//                                    .target_id(node.get("fans_medal").get("medal").get("target_id").getInt())
//                                    .level(node.get("fans_medal").get("medal").get("level").getInt())
//                                    .medal_name(node.get("fans_medal").get("medal").get("medal_name").getString())
//                                    .medal_color(node.get("fans_medal").get("medal").get("medal_color").getInt())
//                                    .intimacy(node.get("fans_medal").get("medal").get("intimacy").getInt())
//                                    .next_intimacy(node.get("fans_medal").get("medal").get("next_intimacy").getInt())
//                                    .day_limit(node.get("fans_medal").get("medal").get("day_limit").getInt())
//                                    .medal_color_start(node.get("fans_medal").get("medal").get("medal_color_start").getInt())
//                                    .medal_color_end(node.get("fans_medal").get("medal").get("medal_color_end").getInt())
//                                    .medal_color_border(node.get("fans_medal").get("medal").get("medal_color_border").getInt())
//                                    .is_lighted(node.get("fans_medal").get("medal").get("is_lighted").getBoolean())
//                                    .light_status(node.get("fans_medal").get("medal").get("light_status").getBoolean())
//                                    .wearing_status(node.get("fans_medal").get("medal").get("wearing_status").getBoolean())
//                                    .score(node.get("fans_medal").get("medal").get("score").getBoolean())
//                                    .build())
//                            .build())
//                    .official(BilibiliOfficialVerify.builder()
//                            .role(node.get("official").get("role").getInt())
//                            .title(node.get("official").get("title").getString())
//                            .desc(node.get("official").get("desc").getString())
//                            .type(node.get("official").get("type").getInt())
//                            .build())
//                    .vip(VipInfo.builder()
//                            .type(node.get("vip").get("type").getInt())
//                            .status(node.get("vip").get("status").getInt())
//                            .due_date(node.get("vip").get("due_date").getString())
//                            .vip_pay_type(node.get("vip").get("vip_pay_type").getString())
//                            .theme_type(node.get("vip").get("theme_type").getInt())
//                            .avatar_subscript(node.get("vip").get("avatar_subscript").getInt())
//                            .nickname_color(node.get("vip").get("nickname_color").getString())
//                            .role(node.get("vip").get("role").getInt())
//                            .avatar_subscript_url(node.get("vip").get("avatar_subscript_url").getString())
//                            .label(VipInfo.Label.builder()
//                                    .path(node.get("vip").get("label").get("path").getString())
//                                    .text(node.get("vip").get("label").get("text").getString())
//                                    .label_theme(node.get("vip").get("label").get("label_theme").getString())
//                                    .text_color(node.get("vip").get("label").get("text_color").getString())
//                                    .bg_style(node.get("vip").get("label").get("bg_style").getString())
//                                    .bg_color(node.get("vip").get("label").get("bg_color").getString())
//                                    .border_color(node.get("vip").get("label").get("border_color").getString())
//                                    .build())
//                            .build())
//                    .pendant(BilibiliPendant.builder()
//                            .pid(node.get("pendant").get("pid").getInt())
//                            .name(node.get("pendant").get("name").getString())
//                            .image(node.get("pendant").get("image").getString())
//                            .expire(node.get("pendant").get("expire").getString())
//                            .image_enhance(node.get("pendant").get("image_enhance").getString())
//                            .image_enhance_frame(node.get("pendant").get("image_enhance_frame").getString())
//                            .build())
//                    .nameplate(BilibiliNameplate.builder()
//                            .nid(node.get("pendant").get("pid").getInt())
//                            .name(node.get("pendant").get("name").getString())
//                            .image(node.get("pendant").get("image").getString())
//                            .image_small(node.get("pendant").get("image_small").getString())
//                            .level(node.get("pendant").get("level").getString())
//                            .condition(node.get("pendant").get("condition").getString())
//                            .build())
//                    .user_honour_info(node.get("user_honour_info").toString())
//                    .theme(node.get("theme").toString())
//                    .sys_notice(node.get("sys_notice").toString())
//                    .live_room(BilibiliLiveRoom.builder()
//                            .roomStatus(node.get("live_room").get("roomStatus").getInt())
//                            .liveStatus(node.get("live_room").get("liveStatus").getInt())
//                            .url(node.get("live_room").get("url").getString())
//                            .title(node.get("live_room").get("title").getString())
//                            .cover(node.get("live_room").get("cover").getString())
//                            .online(node.get("live_room").get("online").getInt())
//                            .roomid(node.get("live_room").get("roomid").getInt())
//                            .roundStatus(node.get("live_room").get("roundStatus").getInt())
//                            .broadcast_type(node.get("live_room").get("broadcast_type").getInt())
//                            .build())
//                    .school(BilibiliSchool.builder()
//                            .name(node.get("school").get("name").getString())
//                            .build())
//                    .profession(node.get("profession").getString())
//                    .series(node.get("series").getString())
//                    .build();
//            return null;
        } else {
            log.error("获取UID: {} 信息错误! {}", uid, result);
            return null;
        }
    }

    @Override
    public BilibiliRelationStat getRelationStat(int uid) {
        Map<String, String> map = new HashMap<>();
        map.put("vmid", String.valueOf(uid));
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.RELATION_STAT, map)
                .cookie(loginInfo)
                .get()
                .buildRequest();
        BiliResult result = Call.doCall(request);
        if (0 == result.getCode()) {
            return result.getData().toObject(BilibiliRelationStat.class);
        }
        return null;
    }
}

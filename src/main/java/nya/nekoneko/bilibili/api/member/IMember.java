package nya.nekoneko.bilibili.api.member;

import nya.nekoneko.bilibili.model.BilibiliNameplate;

import java.util.List;

public interface IMember {
    List<BilibiliNameplate> getAllMedalInfo();
    List<BilibiliNameplate> getMyMedalInfo();
}

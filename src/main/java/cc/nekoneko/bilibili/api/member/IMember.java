package cc.nekoneko.bilibili.api.member;

import cc.nekoneko.bilibili.model.BilibiliNameplate;

import java.util.List;

public interface IMember {
    List<BilibiliNameplate> getAllMedalInfo();
    List<BilibiliNameplate> getMyMedalInfo();
}

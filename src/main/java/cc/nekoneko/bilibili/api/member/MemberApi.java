package cc.nekoneko.bilibili.api.member;

import cc.nekoneko.bilibili.model.BiliResult;
import cc.nekoneko.bilibili.model.BilibiliLoginInfo;
import cc.nekoneko.bilibili.model.BilibiliNameplate;
import cc.nekoneko.bilibili.util.BiliRequestFactor;
import cc.nekoneko.bilibili.util.Call;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Request;
import org.noear.snack.ONode;

import java.util.LinkedList;
import java.util.List;

import static cc.nekoneko.bilibili.config.UrlConfig.ALL_MEDAL_INFO;
import static cc.nekoneko.bilibili.config.UrlConfig.MY_MEDAL_INFO;

@Slf4j
public class MemberApi implements IMember {
    private final BilibiliLoginInfo loginInfo;

    public MemberApi(BilibiliLoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    @Override
    public List<BilibiliNameplate> getAllMedalInfo() {
        Request request = BiliRequestFactor.getBiliRequest()
                .url(ALL_MEDAL_INFO)
                .get()
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        System.out.println(result);
        if (result.getCode() == 0) {
            List<BilibiliNameplate> nameplateList = new LinkedList<>();
            ONode list = result.getData().get("list");
            list.forEach((s, oNode) -> {
                String typeName = oNode.get("name").getString();
                oNode.get("data").forEach(oNode1 -> {
                    oNode1.get("right").forEach(right -> {
                        BilibiliNameplate nameplate = right.toObject(BilibiliNameplate.class);
                        nameplate.setType(typeName);
                        nameplateList.add(nameplate);

                    });
                });
            });
            return nameplateList;
        }
        return null;
    }

    @Override
    public List<BilibiliNameplate> getMyMedalInfo() {
        Request request = BiliRequestFactor.getBiliRequest()
                .url(MY_MEDAL_INFO)
                .get()
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        if (result.getCode() == 0) {
            List<BilibiliNameplate> list = new LinkedList<>();
            ONode node = result.getData();
            node.forEach(oNode -> {
                String name = oNode.get("name").getString();
                oNode.get("list").forEach(item -> {
                    BilibiliNameplate nameplate = item.toObject(BilibiliNameplate.class);
                    nameplate.setType(name);
                    list.add(nameplate);
                });
            });
            return list;
        }
        return null;
    }
}

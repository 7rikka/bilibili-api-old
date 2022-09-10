package nya.nekoneko.bilibili.api.video;

import nya.nekoneko.bilibili.config.UrlConfig;
import nya.nekoneko.bilibili.model.BiliResult;
import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import nya.nekoneko.bilibili.model.BilibiliVideoPlayUrlInfo;
import nya.nekoneko.bilibili.util.BiliRequestFactor;
import nya.nekoneko.bilibili.util.Call;
import okhttp3.Request;
import org.noear.snack.ONode;

import java.util.HashMap;
import java.util.Map;

import static nya.nekoneko.bilibili.config.UrlConfig.GET_VIDEO_URL;

public class VideoApi implements IVideo{
    private final BilibiliLoginInfo loginInfo;

    public VideoApi(BilibiliLoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }
    Map<Integer,String> map=new HashMap<>() {
        {
            put(127, "8K 超高清");
            put(126, "杜比视界");
            put(125, "HDR 真彩色");
            put(120, "4K 超清");
            put(116, "1080P60 高帧率");
            put(112, "1080P+ 高码率");
            put(80, "1080P 高清");
            put(74, "720P60 高帧率");
            put(64, "720P 高清");
            put(32, "480P 清晰");
            put(16, "360P 流畅");
            put(6, "240P 极速");
        }
    };
    @Override
    public BilibiliVideoPlayUrlInfo getPlayUrl(Integer aid, String bvid, Integer cid, Integer qn, Integer fnval) {
        //https://api.bilibili.com/x/player/playurl?
        // avid=800258319
        // bvid=BV1Gy4y1z7Nw
        // cid=256899456
        // qn=120
        // fnver=0
        // fnval=4048
        // fourk=1
        // session=5e2d388164c95e45104e30d2a34e4b30
        Request request = BiliRequestFactor.getBiliRequest()
                .url(GET_VIDEO_URL)
                .addParam("avid", aid)
                .addParam("bvid", bvid)
                .addParam("cid", cid)
                .addParam("qn", qn)
                .addParam("fnver", 0)
                .addParam("fnval", fnval)
                .addParam("fourk", 1)
                .get()
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        ONode data = result.getData();
        ONode dash = data.get("dash");
        if (!dash.isNull()) {
            //处理视频
            data.setNode("vidio_list", dash.get("video"));
            //处理音频
            data.setNode("audio_list", dash.get("audio"));
            //处理杜比全景声
            ONode dolby = dash.get("dolby");
            if (!dolby.isNull()) {
                data.get("audio_list").addNode(dolby.get("audio"));
            }
            //处理无损音轨
            ONode flac = dash.get("flac");
            if (!flac.isNull()) {
                data.get("audio_list").addNode(flac.get("audio"));
            }
        }
        BilibiliVideoPlayUrlInfo videoPlayUrlInfo = result.getData().toObject(BilibiliVideoPlayUrlInfo.class);
        videoPlayUrlInfo.getAudioList().sort((a,b)-> b.getId()-a.getId());
        return videoPlayUrlInfo;
    }
}

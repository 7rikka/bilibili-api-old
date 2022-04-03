package nya.nekoneko.bilibili.model.upload;

import nya.nekoneko.bilibili.model.BilibiliLoginInfo;

import java.io.File;

/**
 * @author Ho
 */
public interface Uploader {
    //{os: "upos", query: "upcdn=bda2&probe_version=20211012", url: "upos-sz-upcdnbda2.bilivideo.com/OK"}
    //{os: "upos", query: "upcdn=qn&probe_version=20211012", url: "upos-sz-upcdnqn.bilivideo.com/OK"}
    //{os: "upos", query: "os=upos&upcdn=ws", url: "upos-sz-upcdnws.acgvideo.com/OK"}
    //{os: "kodo", query: "os=kodo&bucket=bvcupcdnkodobm", url: "up-na0.qbox.me/crossdomain.xml"}

    //upcdn: qn
    //probe_version: 20211012
    //name: 上传中 - 副本.mp4
    //r: upos
    //profile: ugcfx/bup
    //ssl: 0
    //version: 2.10.4.0
    //build: 2100400
    //size: 583841
    //webVersion: 2.0.0
    public String upload(BilibiliLoginInfo bilibiliLoginInfo, File file) throws Exception;
}

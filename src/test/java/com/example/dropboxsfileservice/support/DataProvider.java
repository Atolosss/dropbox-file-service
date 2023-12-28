package com.example.dropboxsfileservice.support;

import lombok.experimental.UtilityClass;
import ru.gmm.demo.model.api.UploadFileDto;

@UtilityClass
public class DataProvider {
    public static UploadFileDto.UploadFileDtoBuilder prepareFile() {
        return UploadFileDto.builder()
                .name("example")
                .base64Data("8ABTH4+fthfHf44aZpfh69g+FXwl8MeC/BPhSa+vPC/hPTf+Er8UzaidPOs3bXdrc6s0el/wBpG122N59gXzNOXdwAf//Z}");
    }
}

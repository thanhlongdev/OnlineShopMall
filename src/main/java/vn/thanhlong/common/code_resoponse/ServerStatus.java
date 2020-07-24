package vn.thanhlong.common.code_resoponse;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ServerStatus {

    OK (200, "OK"),
    BAD_REQUEST (400, "Bad Request"),
    NOT_FOUND(404, "Not found"),
    METHOD_NOT_ALLOW(405, "Method not allow"),
    INTERNAL_SERVER_ERROR(500, "Internal server error"),
    BAD_GATEWAY(502, "Bad gateway");

    Integer code;
    String message;

}

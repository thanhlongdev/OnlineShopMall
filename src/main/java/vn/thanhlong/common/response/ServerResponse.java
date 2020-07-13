package vn.thanhlong.common.response;

import com.google.gson.JsonElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import vn.thanhlong.common.http_response_code.ServerStatus;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ServerResponse {

    protected Boolean status;
    protected Integer code;
    protected JsonElement data;
    protected String messages;

    public ServerResponse setResponse(ServerStatus code, Boolean status, JsonElement data) {
        this.code = code.getCode();
        this.messages = code.getMessage();
        this.status = status;
        this.data = data;
        return this;
    }

    public ServerResponse setResponse(ServerStatus code, Boolean status) {
        this.code = code.getCode();
        this.messages = code.getMessage();
        this.status = status;
        return this;
    }

}

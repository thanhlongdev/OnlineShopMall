package vn.thanhlong;

import vn.thanhlong.common.helper.PassHelper;

public class MainTest {

    public static void main(String[] args) {
        String[] hashed = new PassHelper().hash("admin");
    }

}

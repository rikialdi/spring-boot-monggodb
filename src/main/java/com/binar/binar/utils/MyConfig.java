package com.binar.binar.utils;

import lombok.Data;

@Data
public class MyConfig {

    public final String data = "data";
    public final String statusCode = "statusCode";
    public final String statusMessage = "statusMessage";

    public final String statusSuksesCode = "200";
    public final  String statusSuksesDesc = "Sukses";

    public final String statusFailCode = "500";

    public final String statusNotfoundCode = "404";
    public final  String statusNotfoundDesc = "id tidak ditemukan";


}

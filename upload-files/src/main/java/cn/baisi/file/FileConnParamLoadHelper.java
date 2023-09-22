package cn.baisi.file;

public class FileConnParamLoadHelper {

    private static SSHParamModel paramModel = null;

    public FileConnParamLoadHelper (SSHParamModel paramModel1) {

        FileConnParamLoadHelper.paramModel = paramModel1;
    }
    public static SSHParamModel getParamModel(){

        return paramModel;
    }
}

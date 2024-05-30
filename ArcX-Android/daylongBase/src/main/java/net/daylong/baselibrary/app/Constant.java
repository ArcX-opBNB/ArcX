package net.daylong.baselibrary.app;


public class Constant {
    public static final String WX_APP_ID = "wx6e35864ce9929790";
    public static final int CAMERA_REQUEST_CODE = 100; 
    public static final int ALBUM_REQUEST_CODE = 200; 
    public static final String BASE_URL = "http:

    public static final String BASE_PAGE = BaseApplication.getAppContext().getExternalCacheDir() + "";
    public static final String iMAGE_CACHE_PATH = BASE_PAGE + "/cache/img";
    public static final String iMAGE_CACHE = BASE_PAGE + "/cache";
    public static final String IMAGE_UPLOAD_PATH = BASE_PAGE + "/upload/img/";
    public static final String LOG_PATH = BASE_PAGE + "/log/";
    public static final String UPDATE_PATH = BASE_PAGE + "/update/";
    public static final String SVGA_PATH = BASE_PAGE + "/svga/";
    public static final String ASS_CARD = "card/";


    public static final String ASS_FUN_CARD_PATH = ASS_CARD + "fun/";
    public static final String ASS_FUN_CARD_DIALOG_TITLE_NAME = "ic_card_fun_card_title";

    public static final String ASS_FUN_CARD_HELP = ASS_FUN_CARD_PATH + "ic_help_fun_card";


    

    public static final String IMG_THUMBNAIL_USER_ICON = "?imageMogr2/thumbnail/100x";
    public static final String IMG_THUMBNAIL_POST = "?imageMogr2/thumbnail/200x";
    public static final String IMG_THUMBNAIL_FLAG_ICON = "?imageMogr2/thumbnail/48x";
    
    public static final String IMG_THUMBNAIL_HEIGHT = "?imageMogr2/thumbnail/x";
    public static final String IMG_THUMBNAIL_WIDTH = "?imageMogr2/thumbnail/";

    public static final boolean isDebug = false;
    public static int COUNTDOWN_1_S = 1000;
    public static int COUNTDOWN_1_M = 60 * COUNTDOWN_1_S;
    public static int COUNTDOWN_30_Ms = COUNTDOWN_1_M * 30;
    public static int COUNTDOWN_30_M = 30 * 60;

}

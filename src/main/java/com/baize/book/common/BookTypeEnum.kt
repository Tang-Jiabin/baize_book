package com.baize.book.common

enum class BookTypeEnum(val type: Int, val alias: String) {


    XUAN_HUAN   (100000, "玄幻"),
    QI_HUAN     (100001, "奇幻"),
    WU_XIA      (100010, "武侠"),
    XIAN_XIA    (100011, "仙侠"),
    DU_SHI      (100100, "都市"),
    XIAN_SHI    (100101, "现实"),
    LI_SHI      (100110, "历史"),
    JUN_SHI     (100111, "军事"),
    YOU_XI      (101000, "游戏"),
    TI_YU       (101001, "体育"),
    KE_HUAN     (101010, "科幻"),
    XUAN_YI     (101011, "悬疑"),
    YAN_QING    (101100, "言情"),
    QI_TA       (101101, "其他");


}
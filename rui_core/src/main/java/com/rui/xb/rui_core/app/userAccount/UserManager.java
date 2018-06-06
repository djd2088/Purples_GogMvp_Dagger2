package com.rui.xb.rui_core.app.userAccount;

import com.rui.xb.rui_core.app.userAccount.ot.IUserLoginListener;
import com.rui.xb.rui_core.app.userAccount.ot.User;
import com.rui.xb.rui_core.preference.RuiPreference;

/**
 * Created by Rui on 2018/4/14.
 */

public class UserManager {

    public static void checkUserHasLogin(IUserLoginListener listener){
        if (RuiPreference.getAppFlag(User.EUser.HAS_LOGIN_FLAG.name())){
            listener.hasLogin();
        }else {
            listener.noLogin();
        }
    }
}

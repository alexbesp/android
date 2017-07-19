package com.example.alexanderbespalov.mvpedu.presentation.view.bashOrg;

import com.arellomobile.mvp.MvpView;

public interface BashOrgFragmentView extends MvpView {
    void showRefreshing();
    void hideRefreshing();
    void onDataChanged();
    void hideUpdating();
    void onConnectionFailure();
    void onDataUpdateFailure();
}

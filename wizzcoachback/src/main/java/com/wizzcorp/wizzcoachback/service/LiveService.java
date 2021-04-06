package com.wizzcorp.wizzcoachback.service;

import com.wizzcorp.wizzcoachback.model.Live;

import java.util.List;

public interface LiveService {

    List<Live> findAllLives();

    List<Live> findLiveById(int id);
    public void postLive(Live live);


}

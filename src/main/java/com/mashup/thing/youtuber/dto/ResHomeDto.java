package com.mashup.thing.youtuber.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ResHomeDto {
    private List<ResYouTuberDto> resYouTuberDtos;
    private List<ResSoaringYouTuberDto> resSoaringYouTuberDtos;

    @Getter
    @Builder
    public static class ResSoaringYouTuberDto {

        private Long id;
        private String name;
        private String thumbnail;
        private List<String> tag;
        private Double soaring;

    }


    public ResHomeDto(List<ResYouTuberDto> resYouTuberDtos, List<ResSoaringYouTuberDto> resSoaringYouTuberDtos) {
        this.resYouTuberDtos = resYouTuberDtos;
        this.resSoaringYouTuberDtos = resSoaringYouTuberDtos;
    }

    public ResHomeDto(List<ResSoaringYouTuberDto> resSoaringYouTuberDtos) {
        this.resYouTuberDtos = new ArrayList<>();
        this.resSoaringYouTuberDtos = resSoaringYouTuberDtos;
    }
}
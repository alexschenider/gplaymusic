package com.github.felixgail.gplaymusic.model.shema;

import com.github.felixgail.gplaymusic.api.exceptions.NetworkException;
import com.github.felixgail.gplaymusic.model.abstracts.Signable;
import com.github.felixgail.gplaymusic.model.enums.Provider;
import com.github.felixgail.gplaymusic.model.enums.StreamQuality;
import com.github.felixgail.gplaymusic.model.shema.snippets.ArtRef;
import com.google.gson.annotations.Expose;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class PodcastEpisode extends Signable implements Serializable {

    @Expose
    private List<ArtRef> art;
    @Expose
    private String author;
    @Expose
    private boolean deleted;
    @Expose
    private String description;
    @Expose
    private String durationMillis;
    @Expose
    private String episodeId;
    @Expose
    private String explicitType;
    @Expose
    private String fileSize;
    @Expose
    private String playbackPositionMillis;
    @Expose
    private String publicationTimestampMillis;
    @Expose
    private String seriesId;
    @Expose
    private String seriesTitle;
    @Expose
    private String title;

    public List<ArtRef> getArt() {
        return art;
    }

    public void setArt(List<ArtRef> art) {
        this.art = art;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDurationMillis() {
        return durationMillis;
    }

    public void setDurationMillis(String durationMillis) {
        this.durationMillis = durationMillis;
    }

    public String getID() {
        return episodeId;
    }

    public void setEpisodeId(String episodeId) {
        this.episodeId = episodeId;
    }

    public String getExplicitType() {
        return explicitType;
    }

    public void setExplicitType(String explicitType) {
        this.explicitType = explicitType;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getPlaybackPositionMillis() {
        return playbackPositionMillis;
    }

    public void setPlaybackPositionMillis(String playbackPositionMillis) {
        this.playbackPositionMillis = playbackPositionMillis;
    }

    public String getPublicationTimestampMillis() {
        return publicationTimestampMillis;
    }

    public void setPublicationTimestampMillis(String publicationTimestampMillis) {
        this.publicationTimestampMillis = publicationTimestampMillis;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getSeriesTitle() {
        return seriesTitle;
    }

    public void setSeriesTitle(String seriesTitle) {
        this.seriesTitle = seriesTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Signature getSignature() {
        return super.createSignature(this.getID());
    }

    /**
     * Returns a URL to download a podcast episode in set quality.
     * URL will only be valid for 1 minute.
     * You will likely need to handle redirects.
     * <br>
     * <b>TODO: Find out if free users have access to podcast episodes</b>
     *
     * @param quality quality of the stream
     * @return temporary url to the title
     * @throws IOException Throws an IOException on severe failures (no internet connection...)
     *                     or a {@link NetworkException} on request failures.
     */
    @Override
    public String getStreamURL(StreamQuality quality)
            throws IOException {
        return urlFetcher(quality, Provider.PODCAST, EMPTY_MAP);
    }
}

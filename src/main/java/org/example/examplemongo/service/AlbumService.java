package org.example.examplemongo.service;

import org.example.examplemongo.dto.request.AlbumRequest;
import org.example.examplemongo.dto.response.AlbumResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AlbumService {


    AlbumResponse createAlbum(AlbumRequest albumRequest);
    AlbumResponse updateAlbum(AlbumRequest albumRequest,Long id);
    Page<AlbumResponse> getAlbums(Pageable pageable);
    AlbumResponse getAlbumsByTitle(String title, Pageable pageable);
    void deleteAlbum(Long id);

}

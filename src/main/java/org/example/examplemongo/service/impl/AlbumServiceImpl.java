package org.example.examplemongo.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.examplemongo.domain.entity.Album;
import org.example.examplemongo.dto.request.AlbumRequest;
import org.example.examplemongo.dto.response.AlbumResponse;
import org.example.examplemongo.mapper.AlbumMapper;
import org.example.examplemongo.repository.AlbumRepository;
import org.example.examplemongo.service.AlbumService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AlbumServiceImpl implements AlbumService {
    private  final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;

    @Override
    public AlbumResponse createAlbum(AlbumRequest albumRequest) {

        Album album= albumMapper.toEntity(albumRequest);
        Album savedAlbum= albumRepository.save(album);
        return albumMapper.toResponse(savedAlbum);
    }

    @Override
    public AlbumResponse updateAlbum(AlbumRequest albumRequest, Long id) {
        Album existsAlbum= albumRepository.findById(id).orElse(null);
        albumMapper.updateEntity(existsAlbum,albumRequest);
        Album savedAlbum= albumRepository.save(existsAlbum);
        return albumMapper.toResponse(savedAlbum);
    }

    @Override
    public Page<AlbumResponse> getAlbums(Pageable pageable) {
        return albumRepository.findAll(pageable).map(albumMapper::toResponse);
    }

    @Override
    public AlbumResponse getAlbumsByTitle(String title, Pageable pageable) {
        return null;
    }

    @Override
    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }
}
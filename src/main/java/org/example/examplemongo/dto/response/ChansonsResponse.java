package org.example.examplemongo.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChansonsResponse {

    private Long chansonsId;
    private String title;
    private String artist;
    private Integer year;

}

package me.adrigamer2950.gametests.paper.objects;

import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class GameTest {

    private final String name;
    @Setter
    private String structureData;
}

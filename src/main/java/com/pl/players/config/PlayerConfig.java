package com.pl.players.config;

import com.pl.players.model.Player;
import com.pl.players.service.PlayerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayerConfig {

    @Bean
    CommandLineRunner commandLineRunner(PlayerService playerService) {
        return args -> {
            Player gabriel = new Player(
                    "Gabriel"
            );

            Player alex = new Player(
                    "Alex"
            );
        };
    }
}

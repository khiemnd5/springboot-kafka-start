package vn.edu.stepup.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author khiemnd5
 * @since : 12/31/22, Sat
 */

@RestController
@RequestMapping("/run/job")
@Slf4j
public class GameController {

    @GetMapping("/game")
    private ResponseEntity<?> getGames() {
        return new ResponseEntity<>("abc", HttpStatus.OK);
    }
//
//    @Scheduled(fixedDelay = 1000)
//    private void addGame() {
//        log.info("====just add game=====");
//        map = new HashMap<>();
//        map.put("game" + new Random().nextInt(), "Value=" + new Random().nextInt());
//        return;
//    }
}

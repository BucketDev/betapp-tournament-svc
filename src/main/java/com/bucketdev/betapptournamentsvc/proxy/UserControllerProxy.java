package com.bucketdev.betapptournamentsvc.proxy;

import com.bucketdev.betapptournamentsvc.dto.UserDTO;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@FeignClient(name = "betapp-profile-svc")
@RibbonClient(name = "betapp-profile-svc")
public interface UserControllerProxy {

    @GetMapping("users/displayName/{name}")
    ResponseEntity<Set<UserDTO>> findByDisplayName(@PathVariable String name);

}

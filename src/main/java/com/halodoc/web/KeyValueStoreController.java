package com.halodoc.web;

import com.halodoc.api.GetDataResponse;
import com.halodoc.api.SaveApiRequest;
import com.halodoc.api.Success;
import com.halodoc.service.KeyValueStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class KeyValueStoreController extends BaseController {


    private final KeyValueStoreService keyValueStoreService;

    public KeyValueStoreController(@Autowired KeyValueStoreService keyValueStoreService) {
        this.keyValueStoreService = keyValueStoreService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Success<String> save(@RequestBody SaveApiRequest request) {
        this.keyValueStoreService.save(request);
        return new Success<>("Saved Successfully.");
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping("/{key}")
    public Success<List<GetDataResponse>> getDataResponse(@PathVariable("key") String key) {
        return new Success<>(this.keyValueStoreService.getCities(key));
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping("/places/{attribute}/{value}")
    public Success<List<String>> getCities(@PathVariable("attribute") String attribute, @PathVariable("value") String value) {
        return new Success<>(this.keyValueStoreService.getCities(attribute, value));
    }
}

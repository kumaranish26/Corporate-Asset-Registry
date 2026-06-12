package com.example.Saloon.Controller;

import com.example.Saloon.Entity.Asset;
import com.example.Saloon.Service.AssetService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class AssetController {

    // TODO: Define the AssetService variable (should be final)
    private final AssetService assetService;

    // TODO: Inject the AssetService using Constructor Injection
    public AssetController(AssetService assetService)
    {
        this.assetService=assetService;
    }


    // 1. POST: Add a new asset
    // TODO: Map this method to the URL "/add"
    // TODO: Use @RequestBody to map the JSON input to the Asset object
    @PostMapping("/add")
    public Asset addAsset(@RequestBody Asset asset) {
        return assetService.addAsset(asset);
    }

    // 2. GET: Retrieve all assets
    // TODO: Map this method to the URL "/all"
    @GetMapping("/all")
    public List<Asset> getAllAssets() {
        return assetService.getAllAssets();
    }

    // 3. GET: Retrieve asset by ID
    // TODO: Map this method to "/{id}"
    // TODO: Use @PathVariable to extract the "id" from the URL
    @GetMapping("/{id}")
    public Asset getAssetById(@PathVariable Long id) {
        return assetService.getAssetById(id);
    }

    // 4. GET: Retrieve assets by category
    // TODO: Map this method to "/category/{category}"
    // TODO: Use @PathVariable to extract the "category"
    @GetMapping("/category/{category}")
    public List<Asset> getAssetsByCategory(@PathVariable String category) {
        return assetService.getAssetsByCategory(category);
    }

    // 5. PUT: Update an existing asset
    // TODO: Map this to "/update/{id}"
    // TODO: Use @PathVariable for the ID and @RequestBody for the asset details
    @PutMapping("/update/{id}")
    public Asset updateAsset(@PathVariable Long id, @RequestBody Asset assetDetails) {
        return assetService.updateAsset(id,assetDetails);
    }

    // 6. DELETE: Remove an asset
    // TODO: Map this to "/delete/{id}"
    // TODO: Use @PathVariable for the ID
    @DeleteMapping("/delete/{id}")
    public String deleteAsset(@PathVariable Long id) {
        return assetService.deleteAsset(id);
    }
}

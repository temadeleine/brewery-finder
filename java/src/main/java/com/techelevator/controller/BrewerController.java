package com.techelevator.controller;


import com.techelevator.dao.BrewerDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Brewer;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class BrewerController {

    private BrewerDao brewerDao;

    public BrewerController(BrewerDao brewerDao) {
        this.brewerDao = brewerDao;
    }

    @RequestMapping(path = "/brewers", method = RequestMethod.GET)
    public List<Brewer> listAll() {
        return brewerDao.listAll();
    }

    @RequestMapping(path = "/breweries/brewers/{brewery_id}", method = RequestMethod.GET)
    public List<Brewer> listBrewersByBreweryId(@PathVariable int brewery_id) {
        return brewerDao.listBrewersByBreweryId(brewery_id);
    }

    @RequestMapping(path = "/brewers/{brewer_id}", method = RequestMethod.GET)
    public Brewer getBrewerByBrewerId(@PathVariable int brewer_id){
        return brewerDao.getBrewerByBrewerId(brewer_id);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(path = "/brewers", method = RequestMethod.POST)
    public Brewer createBrewer(@Valid @RequestBody Brewer brewer) {
        this.brewerDao.updateRole(brewer.getBrewerId());
        return brewerDao.createBrewer(brewer.getBrewerId(), brewer.getBreweryId());
    }


}

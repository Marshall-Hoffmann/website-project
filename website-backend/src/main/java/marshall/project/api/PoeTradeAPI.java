package marshall.project.api;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import marshall.project.model.TradeItem;
import marshall.project.service.PoeTradeService;

@RestController
@CrossOrigin
public class PoeTradeAPI {

	@Autowired
	PoeTradeService poeTradeService;
	
	@RequestMapping(value="/poe-trade/getTradeItems", method=RequestMethod.GET)
	public ResponseEntity<List<TradeItem>> getTradeItems(@RequestParam String emailId) {
		try {
			System.out.println("getId: " + emailId);
			List<TradeItem> tradeItems = poeTradeService.getTradeItems(emailId);
			return new ResponseEntity<List<TradeItem>>(tradeItems, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}
	
	@RequestMapping(value="/poe-trade/addTradeItem", method=RequestMethod.POST)
	public ResponseEntity<Integer> addTradeItem(@RequestBody TradeItem tradeItem) {
		try {
			Integer itemId = poeTradeService.addTradeItem(tradeItem);
			return new ResponseEntity<Integer>(itemId, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}
	
	@RequestMapping(value="/poe-trade/deleteTradeItem/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteTradeItem(@PathVariable Integer id) {
		try {
			Integer itemId = poeTradeService.deleteTradeItem(id);
			return new ResponseEntity<Integer>(itemId, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}
}

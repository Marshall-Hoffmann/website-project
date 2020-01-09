package marshall.project.api;

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

import marshall.project.model.Collection;
import marshall.project.model.TradeItem;
import marshall.project.service.PoeTradeService;

@RestController
@CrossOrigin
public class PoeTradeAPI {

	@Autowired
	PoeTradeService poeTradeService;
	
	@RequestMapping(value="/poe-trade/tradeItems", method=RequestMethod.GET)
	public ResponseEntity<List<TradeItem>> getTradeItems(@RequestParam Integer userId) {
		try {
			List<TradeItem> tradeItems = poeTradeService.getTradeItems(userId);
			return new ResponseEntity<List<TradeItem>>(tradeItems, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}
	
	@RequestMapping(value="/poe-trade/tradeItems", method=RequestMethod.POST)
	public ResponseEntity<Integer> addTradeItem(@RequestBody TradeItem tradeItem) {
		try {
			Integer itemId = poeTradeService.addTradeItem(tradeItem);
			return new ResponseEntity<Integer>(itemId, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}
	
	@RequestMapping(value="/poe-trade/tradeItems/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteTradeItem(@PathVariable Integer id) {
		try {
			Integer itemId = poeTradeService.deleteTradeItem(id);
			return new ResponseEntity<Integer>(itemId, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}
	
	@RequestMapping(value="/poe-trade/collections", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getCollections(@RequestParam Integer userId) {
		try {
			List<String> collections = poeTradeService.getCollections(userId);
			return new ResponseEntity<List<String>>(collections, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}
	
	@RequestMapping(value="/poe-trade/collections", method=RequestMethod.POST)
	public ResponseEntity<Integer> addCollection(@RequestBody Collection collection) {
		try {
			Integer collectionId = poeTradeService.addCollection(collection);
			return new ResponseEntity<Integer>(collectionId, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}
}

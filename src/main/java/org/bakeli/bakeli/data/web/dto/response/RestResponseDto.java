package org.bakeli.bakeli.data.web.dto.response;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class RestResponseDto {

    public static Map<Object,Object> response(
            Object results,
            Object pages,
            Object currentPage,
            Object previousPage,
            Object nextPage,
            Object totalItems,
            Object totalPages,
            HttpStatus status
    ){
        Map<Object,Object> response = new HashMap<Object,Object>();
        response.put("results",results);
        response.put("pages",pages);
        response.put("currentPage",currentPage);
        response.put("PreviousPage", previousPage);
        response.put("nextPage", nextPage);

        response.put("totalItems",totalItems);
        response.put("totalPages",totalPages);
        response.put("statuts", status.value());

        return response;
    }

    //surchage quand ya pas de pagination
    public static Map<Object,Object> response(
            Object results,
            HttpStatus status
    ){
        Map<Object,Object> response = new HashMap<Object,Object>();
        response.put("statuts", status.value());
        response.put("results",results);


        return response;
    }
}

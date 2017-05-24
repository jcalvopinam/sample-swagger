/*
MIT License

Copyright (c) 2017 JUAN CALVOPINA M

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

package com.jcalvopinam.controller;

import com.jcalvopinam.domain.Contact;
import com.jcalvopinam.service.ContactService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by juanca on 5/18/17.
 */
@Api(value = "ContactController Endpoint",
        description = "Endpoint for managing contacts",
        basePath = "personal-information/v1")
@RestController
@RequestMapping(value = "/personal-information/v1")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @ApiOperation(value = "Retrieves all contacts.", responseContainer = "List<Contact>")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal server error occurred")})
    @GetMapping(value = "/contacts")
    public List<Contact> findAll() {
        return contactService.findAll();
    }

    @ApiOperation(value = "Finds a contact by {id}.", responseContainer = "Contact")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal server error occurred")})
    @GetMapping(value = "/contact/{id}")
    public Contact findContact(@PathVariable("id") Long id) {
        return contactService.find(id);
    }

    @ApiOperation(value = "Adds a new contact. It is necessary to fill in the attributes as shown in the 'Example Value'.",
            responseContainer = "Contact")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal server error occurred")})
    @PostMapping(value = "/contact")
    public Contact createContact(@RequestBody Contact contact) {
        return contactService.save(contact);
    }

    @ApiOperation(value = "Updates an existing contact by {id}.", responseContainer = "Contact")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal server error occurred")})
    @PutMapping(value = "/contact/{id}")
    public Contact updateContact(@PathVariable("id") Long id, @RequestBody Contact contact) {
        return contactService.update(id, contact);
    }

    @ApiOperation(value = "Deletes an existing contact by {id}.", responseContainer = "void")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal server error occurred")})
    @DeleteMapping(value = "/contact/{id}")
    public void deleteContact(@PathVariable("id") Long id) {
        contactService.delete(id);
    }

}

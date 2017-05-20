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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by juanca on 5/18/17.
 */
@RestController
@RequestMapping(value = "/personal-information/v1")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping(value = "/contacts")
    public List<Contact> findAll() {
        return contactService.findAll();
    }

    @GetMapping(value = "/contact/{id}")
    public Contact findContact(@PathVariable("id") Long id) {
        return contactService.find(id);
    }

    @PostMapping(value = "/contact")
    public Contact createContact(@RequestBody Contact contact) {
        return contactService.save(contact);
    }

    @PutMapping(value = "/contact/{id}")
    public Contact updateContact(@PathVariable("id") Long id, @RequestBody Contact contact) {
        return contactService.update(id, contact);
    }

    @DeleteMapping(value = "/contact/{id}")
    public void deleteContact(@PathVariable("id") Long id) {
        contactService.delete(id);
    }

}

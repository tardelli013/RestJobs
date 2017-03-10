package br.com.tardelli.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tardelli.model.JobsModel;
import br.com.tardelli.repository.JobsRepository;


/**
 * 
 * @author tardelli
 *
 */
@RequestMapping("/s/")
public class JobsController {

	@Autowired
	JobsRepository jobsRepository;

	@GET
	@RequestMapping("/jobs")
	@Produces(MediaType.APPLICATION_JSON)
	public List<JobsModel> getJobs() {

		return jobsRepository.findAll();

	}

	

}

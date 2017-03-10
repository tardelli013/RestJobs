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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tardelli.model.JobsModel;
import br.com.tardelli.repository.JobsRepository;

@RestController
@RequestMapping("/api/")
public class JobsController {

	@Autowired
	JobsRepository jobsRepository;

	@GET
	@RequestMapping("/jobs")
	@Produces(MediaType.APPLICATION_JSON)
	public List<JobsModel> getJobs() {

		return jobsRepository.findAll();

	}

	@POST
	@RequestMapping("/addjobs")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addJob(@RequestBody JobsModel job) {
		jobsRepository.save(job);

		System.out.println(job.getMsg());

		String result = "Job saved : " + job;
		return Response.status(201).entity(result).build();

	}

	@DELETE
	@RequestMapping("/deljobs/{job}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delJob(@PathVariable("job") String job) {
		jobsRepository.delete(job);

		String result = "Job removed: " + job;
		return Response.status(201).entity(result).build();
	}
}

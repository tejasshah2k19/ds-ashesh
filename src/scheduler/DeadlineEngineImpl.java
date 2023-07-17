package scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import scheduler.Schedule.Status;

public class DeadlineEngineImpl implements DeadlineEngine {
	List<Schedule> schedules;

	public DeadlineEngineImpl() {
		this.schedules = new ArrayList<Schedule>();
	}

	public long schedule(long deadlineMs) {
		Schedule s = new Schedule(deadlineMs);
		schedules.add(s);
		return s.getId();
	}

	public boolean cancel(long requestId) {
		Optional<Schedule> schedule = this.schedules.stream().parallel().filter(s -> s.getId() == requestId)
				.findFirst();
		if (schedule.isPresent()) {
			return this.schedules.remove(schedule.get());
		} else {
			return false;
		}
	}

	public int poll(long nowMs, Consumer<Long> handler, int maxPoll) {

		List<Schedule> allNowMs = this.schedules.stream().parallel().filter(s -> s.getDeadlineMs() == nowMs)
				.limit(maxPoll).collect(Collectors.toList());
//		allNowMs.stream().
		allNowMs.forEach(s->handler.accept(s.getId()));
		this.schedules.stream().parallel().filter(s -> s.getDeadlineMs() == nowMs).limit(maxPoll)
				.forEach(s -> s.setStatus(Status.COMPLETED));
		return allNowMs.size();
	}

	public int size() {
		return this.schedules.size();
	}

}

class Schedule {
	private Long id;
	private Long deadlineMs;
	private Status status;

	public Schedule(Long deadLineMs) {
		this.deadlineMs = deadLineMs;
		this.status = Status.QUEUED;
		this.id = (long) (Math.random() * 1000000000000000000L);
	}

	enum Status {
		QUEUED, COMPLETED, FAILED;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDeadlineMs() {
		return deadlineMs;
	}

	public void setDeadlineMs(Long deadlineMs) {
		this.deadlineMs = deadlineMs;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}

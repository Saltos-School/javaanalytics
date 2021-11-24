package com.indra;

import java.util.Optional;

public class MinMax {

	private Integer min;
	private Integer max;
	
	public MinMax(Integer min, Integer max) {
		super();
		this.min = min;
		this.max = max;
	}
	
	public Integer getMin() {
		return min;
	}
	
	public void setMin(Integer min) {
		this.min = min;
	}
	
	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public static Optional<MinMax> empty() {
		return Optional.empty();
	}
	
	public static Optional<MinMax> ganador(Optional<MinMax> acc, Integer i) {
		if (acc.isEmpty()) {
			MinMax minMax = new MinMax(i, i);
			return Optional.ofNullable(minMax);
		} else {
			MinMax minMax = acc.get();
			int min = minMax.getMin();
			int max = minMax.getMax();
			MinMax nuevoMinMax = new MinMax(i < min ? i : min, i > max ? i : max);
			return Optional.ofNullable(nuevoMinMax);
		}
	}
	
	public static Optional<MinMax> ganador(Optional<MinMax> i, Optional<MinMax> j) {
		if (i.isEmpty()) {
			return j;
		}
		if (j.isEmpty()) {
			return i;
		}
		int minI = i.get().getMin();
		int maxI = i.get().getMax();
		int minJ = j.get().getMin();
		int maxJ = j.get().getMax();
		MinMax nuevoMinMax = new MinMax(minI < minJ ? minI : minJ, maxI > maxJ ? maxI : maxJ);
		return Optional.ofNullable(nuevoMinMax);
	}
	
	@Override
	public String toString() {
		return "MinMax [min=" + min + ", max=" + max + "]";
	}
	
	
}

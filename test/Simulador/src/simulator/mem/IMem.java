package simulator.mem;

public interface IMem {
	public String read(String address) throws MemException;
	public void write(String address, String content) throws MemException;
}

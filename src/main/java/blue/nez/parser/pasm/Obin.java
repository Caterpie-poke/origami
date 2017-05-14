package blue.nez.parser.pasm;

public class Obin extends PAsmInst {
	public final int[] bits;

	public Obin(int[] bits, PAsmInst next) {
		super(next);
		this.bits = bits;
	}

	@Override
	public PAsmInst exec(PAsmContext px) throws PAsmTerminationException {
		int c = getbyte(px);
		if (c == 0) {
			if (neof(px)) {
				move(px, 1);
			}
			return this.next;
		}
		if (bitis(this.bits, c)) {
			move(px, 1);
		}
		return this.next;
	}

}
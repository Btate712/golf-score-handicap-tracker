public class Hole {
    private int holeNumber;
    private int par;

    public Hole(int holeNumber, int par) {
        validateConstructorInput(holeNumber, par);
        this.holeNumber = holeNumber;
        this.par = par;
    }

    public int getHoleNumber() {
        return holeNumber;
    }

    public int getHolePar() {
        return par;
    }

    private void validateConstructorInput(int holeNumber, int par) {
        validateHoleNumber(holeNumber);
        validatePar(par);
    }

    private void validateHoleNumber(int holeNumber) {
        if (holeNumber > GlobalConstants.MAX_HOLE_NUMBER) {
            throw new IllegalArgumentException("Cannot assign hole number greater than " + GlobalConstants.MAX_HOLE_NUMBER + ".");
        }

        if (holeNumber < 1) {
            throw new IllegalArgumentException("Cannot assign hole number less than 1.");
        }
    }

    private void validatePar(int par) {
        if (par > GlobalConstants.MAX_PAR) {
            throw new IllegalArgumentException("Cannot assign par value greater than " + GlobalConstants.MAX_PAR + ".");
        }

        if (par < GlobalConstants.MIN_PAR) {
            throw new IllegalArgumentException("Cannot assign par value less than " + GlobalConstants.MIN_PAR + ".");
        }
    }
}

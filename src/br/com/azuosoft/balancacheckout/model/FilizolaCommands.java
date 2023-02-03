package br.com.azuosoft.balancacheckout.model;

/**
 *
 * @author Leandro
 */
public class FilizolaCommands implements IScaleCommands {

    @Override
    public byte[] getWeight() {
        return new byte[]{0x05};
    }
    
}

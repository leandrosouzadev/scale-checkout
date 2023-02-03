package br.com.azuosoft.scalecheckout.model;

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

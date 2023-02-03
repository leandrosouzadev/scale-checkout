package br.com.azuosoft.scalecheckout.model;

/**
 *
 * @author Leandro
 */
public class ElginCommands implements IScaleCommands {

    @Override
    public byte[] getWeight() {
        return new byte[]{0x05};
    }
    
}

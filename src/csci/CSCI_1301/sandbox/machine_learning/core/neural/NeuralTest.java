package csci.CSCI_1301.sandbox.machine_learning.core.neural;

/**
 * Created by jposton on 2/10/16.
 */
public class NeuralTest {
    public static void main (String [] args) {
        String[] inputs = {"true", "false"};

        Neuron xor = new Neuron(0.5f);
        Neuron left = new Neuron(1.5f);
        Neuron right = new Neuron(0.5f);
        left.setWeight(-1.0f);
        right.setWeight(1.0f);
        xor.connect(left, right);

        for (String val : inputs) {
            Neuron op = new Neuron(0.0f);
            op.setWeight(Boolean.parseBoolean(val));
            left.connect(op);
            right.connect(op);
        }

        xor.fire();

        System.out.println("Result: " + xor.isFired());

    }
}
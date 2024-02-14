package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkLowLevel.MotorType;
import frc.robot.Constants.IntakeConstants;
import frc.robot.Constants.IntakeConstants.IntakeState;
import frc.robot.Constants.IntakeConstants.ArmState;

public class Intake extends SubsystemBase{

    private CANSparkFlex r1;
    private CANSparkFlex r2;
    //roller motors
    private CANSparkFlex a1;
    //angle motor; will need PID

    private IntakeState intakeState;
    //roller
    private ArmState a1State;
    //member variable intake state; found in constants

    public Intake(){
        r1 = new CANSparkFlex(Constants.IntakeConstants.r1Id, MotorType.kBrushless);
        r2 = new CANSparkFlex(Constants.IntakeConstants.r2Id, MotorType.kBrushless);
        r2.follow(r1);
        a1 = new CANSparkFlex(Constants.IntakeConstants.a1Id, MotorType.kBrushless);
        //r2.setInverted(true);
        //intialize member variables (create the motors)
        intakeState = IntakeState.OFF;
        a1State = ArmState.NEUTRAL;
        //when intake is made, it'll be off (not spinning  of course)
        a1.getPIDController().setP(IntakeConstants.armkP);
        a1.getPIDController().setP(IntakeConstants.armkI);
        a1.getPIDController().setP(IntakeConstants.armkD);
    }

    @Override
    //I'm guessing this means that it changes the objects made by the class
    public void periodic() {
        r1.set(intakeState.speed);
        a1.set(a1State.pos);
        //have the motors constantly run the speed that's given
        //only have r1 here because r2 will mimic what r1 does
        a1.getPIDController().setReference(a1State.pos, ControlType.kPosition);
    }



    public void setState(IntakeState state) {
        intakeState = state;
        //changing intake state with this function
    }

    public void seta1State(ArmState state){
        a1State = state;
        //changing angle motor state with this function
    }


}

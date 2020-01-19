import com.acmerobotics.roadrunner.geometry.Pose2d
import com.acmerobotics.roadrunner.geometry.Vector2d
import com.acmerobotics.roadrunner.path.heading.ConstantInterpolator
import com.acmerobotics.roadrunner.path.heading.HeadingInterpolator
import com.acmerobotics.roadrunner.path.heading.LinearInterpolator
import com.acmerobotics.roadrunner.path.heading.SplineInterpolator
import com.acmerobotics.roadrunner.trajectory.Trajectory
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder
import com.acmerobotics.roadrunner.trajectory.constraints.DriveConstraints
import javafx.geometry.Pos

object TrajectoryGen {
    private val constraints = DriveConstraints(60.0, 70.0, 0.0, 270.0.toRadians, 270.0.toRadians, 0.0)
    private val startPose = Pose2d(10.0, -60.0, 0.0)

    fun createTrajectory(): ArrayList<Trajectory> {
        val list = ArrayList<Trajectory>()

        val builder1 = TrajectoryBuilder(Pose2d(-30.0, -60.0, 0.0), constraints)

        // dump routine
        builder1
            //.splineTo(Pose2d(-50.0, -32.0, 180.0.toRadians))
            //.setReversed(true)
            //.splineTo(Pose2d(10.0, -60.0, 180.0.toRadians))
            //.splineTo(Pose2d(50.0, -30.0, 180.0.toRadians))
            //.setReversed(true)
            //.splineTo(Pose2d(10.0, -60.0, 180.0.toRadians), SplineInterpolator(180.0.toRadians, 180.0.toRadians))
            .strafeTo(Vector2d(-44.0, -30.0)).splineTo(Pose2d(0.0, -36.0, 0.0))
            .splineTo(Pose2d(40.0, -30.0, 0.0))
            .setReversed(true)
            .splineTo(Pose2d(0.0, -36.0, 0.0))
            .splineTo(Pose2d(-64.0, -30.0, 0.0))
            .setReversed(false)
            .splineTo(Pose2d(0.0, -36.0, 0.0), SplineInterpolator(0.0, 0.0))
            .splineTo(Pose2d(50.0, -30.0, 0.0), SplineInterpolator(0.0, 0.0))
            .lineTo(Vector2d(50.0, -35.0), SplineInterpolator(0.0, (-90.0).toRadians))
            .lineTo(Vector2d(50.0, -30.0), SplineInterpolator((-90.0).toRadians, (-90.0).toRadians))
            .lineTo(Vector2d(50.0, -40.0))
            .splineTo(Pose2d(40.0, -60.0, (180.0).toRadians))
            //.addMarker(40.0, -60.0, (180.0).toRadians)
        // weird reversed profiles
        // builder
             //.setReversed(true)
             //.splineTo(Pose2d(-12.0, -42.0, 180.0.toRadians), SplineInterpolator(180.0.toRadians, startPose.heading))// y = 39 is halfway between the skybridge and partner with 6" on either side
             //.splineTo(Pose2d(28.0, -42.0, 180.0.toRadians), SplineInterpolator(180.0.toRadians, 180.0.toRadians))
             //.splineTo(Pose2d(48.0, -33.0, -90.0.toRadians), SplineInterpolator(180.0.toRadians, -90.0.toRadians))
            //.lineTo(Vector2d(48.0, -26.0), ConstantInterpolator(-90.0.toRadians))


        list.add(builder1.build())
        return list
    }

    fun drawOffbounds() {
        GraphicsUtil.fillRect(Vector2d(0.0, -63.0), 18.0, 18.0) // robot against the wall
    }
}

val Double.toRadians get() = (Math.toRadians(this))
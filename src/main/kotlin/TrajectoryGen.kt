import com.acmerobotics.roadrunner.geometry.Pose2d
import com.acmerobotics.roadrunner.geometry.Vector2d
import com.acmerobotics.roadrunner.trajectory.Trajectory
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder
import com.acmerobotics.roadrunner.trajectory.constraints.DriveConstraints
import com.acmerobotics.roadrunner.trajectory.constraints.MecanumConstraints
import com.acmerobotics.roadrunner.trajectory.constraints.TrajectoryConstraints
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.PI

object TrajectoryGen {
    // Remember to set these constraints to the same values as your DriveConstants.java file in the quickstart
    private val driveConstraints = DriveConstraints(60.0, 60.0, 0.0, 270.0.toRadians, 270.0.toRadians, 0.0)

    // Remember to set your track width to an estimate of your actual bot to get accurate trajectory profile duration!
    private const val trackWidth = 16.0

    private val combinedConstraints = MecanumConstraints(driveConstraints, trackWidth)

    private val startPose = Pose2d(-63.0, 15.0, 0.0)

    fun createTrajectory(): ArrayList<Trajectory> {

        val list = ArrayList<Trajectory>()



        // PATH #1 for closest square

        val builder1 = TrajectoryBuilder(startPose, startPose.heading, combinedConstraints)

        val builder2 = TrajectoryBuilder(Pose2d(0.0, 5.0, 0.0), 0.0, combinedConstraints)

        val builder3 = TrajectoryBuilder(Pose2d(0.0, 13.0, 0.0), 0.0, combinedConstraints)

        val builder4 = TrajectoryBuilder(Pose2d(0.0, 21.0, 0.0), 0.0, combinedConstraints)

        val builder5 = TrajectoryBuilder(Pose2d(0.0, 62.0, 0.0), 0.0, combinedConstraints)

        val builder6 = TrajectoryBuilder(Pose2d(14.0, 62.0, 0.0), true, combinedConstraints)

        val builder7 = TrajectoryBuilder(Pose2d(-38.0, 50.0, 270.0.toRadians), 270.0.toRadians, combinedConstraints)

        val builder8 = TrajectoryBuilder(Pose2d(0.0, 36.0, 0.0), 0.0, combinedConstraints)

        val builder9 = TrajectoryBuilder(Pose2d(0.0, 62.0, 0.0), 0.0, combinedConstraints)

        builder1
            .forward(39.0)
            .splineTo(Vector2d(0.0, 5.0), 0.0)
        builder2
            .strafeLeft(8.0)
        builder3
            .strafeLeft(8.0)
        builder4
            .strafeLeft(41.0)
        builder5
            .forward(14.0)
        builder6
            .splineTo(Vector2d(-26.0, 36.0), 180.0.toRadians)
            .splineTo(Vector2d(-38.0, 50.0), 90.0.toRadians)
        builder7
            .splineTo(Vector2d(-26.0, 36.0), 0.0)
            .splineTo(Vector2d(0.0, 36.0), 0.0)
        builder8
            .strafeLeft(26.0)
        builder9
            .forward(10.0)


        // Path #2 for middle square


        /*val builder1 = TrajectoryBuilder(startPose, startPose.heading, combinedConstraints)

        val builder2 = TrajectoryBuilder(Pose2d(0.0, 5.0, 0.0), 0.0, combinedConstraints)

        val builder3 = TrajectoryBuilder(Pose2d(0.0, 13.0, 0.0), 0.0, combinedConstraints)

        val builder4 = TrajectoryBuilder(Pose2d(0.0, 21.0, 0.0), 0.0, combinedConstraints)

        val builder5 = TrajectoryBuilder(Pose2d(37.0, 39.0, 0.0), true, combinedConstraints)

        val builder6 = TrajectoryBuilder(Pose2d(-38.0, 50.0, 270.0.toRadians), 270.0.toRadians, combinedConstraints)

        val builder7 = TrajectoryBuilder(Pose2d(0.0, 36.0, 0.0), 0.0, combinedConstraints)

        val builder8 = TrajectoryBuilder(Pose2d(34.0, 39.0, 0.0), 0.0, combinedConstraints)

        builder1
            .forward(39.0)
            .splineTo(Vector2d(0.0, 5.0), 0.0)
        builder2
            .strafeLeft(8.0)
        builder3
            .strafeLeft(8.0)
        builder4
            .splineTo(Vector2d(37.0, 39.0), 0.0)
        builder5
            .splineTo(Vector2d(-26.0, 36.0), 180.0.toRadians)
            .splineTo(Vector2d(-38.0, 50.0), 90.0.toRadians)
        builder6
            .splineTo(Vector2d(-26.0, 36.0), 0.0)
            .splineTo(Vector2d(0.0, 36.0), 0.0)
        builder7
            .splineTo(Vector2d(34.0, 39.0), 0.0)
        builder8
            .back(22.0)*/



        // Path #3 for the farthest square

        /*val builder1 = TrajectoryBuilder(startPose, startPose.heading, combinedConstraints)

        val builder2 = TrajectoryBuilder(Pose2d(0.0, 5.0, 0.0), 0.0, combinedConstraints)

        val builder3 = TrajectoryBuilder(Pose2d(0.0, 13.0, 0.0), 0.0, combinedConstraints)

        val builder4 = TrajectoryBuilder(Pose2d(0.0, 21.0, 0.0), 0.0, combinedConstraints)

        val builder5 = TrajectoryBuilder(Pose2d(62.0, 62.0, 0.0), true, combinedConstraints)

        val builder6 = TrajectoryBuilder(Pose2d(-38.0, 50.0, 270.0.toRadians), 270.0.toRadians, combinedConstraints)

        val builder7 = TrajectoryBuilder(Pose2d(0.0, 36.0, 0.0), 0.0, combinedConstraints)

        val builder8 = TrajectoryBuilder(Pose2d(59.0, 62.0, 0.0), 0.0, combinedConstraints)

        builder1
            .forward(39.0)
            .splineTo(Vector2d(0.0, 5.0), 0.0)
        builder2
            .strafeLeft(8.0)
        builder3
            .strafeLeft(8.0)
        builder4
            .splineTo(Vector2d(62.0,  62.0), 0.0)
        builder5
            .splineTo(Vector2d(-26.0, 36.0), 180.0.toRadians)
            .splineTo(Vector2d(-38.0, 50.0), 90.0.toRadians)
        builder6
            .splineTo(Vector2d(-26.0, 36.0), 0.0)
            .splineTo(Vector2d(0.0, 36.0), 0.0)
        builder7
            .splineTo(Vector2d(59.0, 62.0), 0.0)
        builder8
            .back(48.0)*/


        list.add(builder1.build());
        list.add(builder2.build());
        list.add(builder3.build());
        list.add(builder4.build());
        list.add(builder5.build());
        list.add(builder6.build());
        list.add(builder7.build());
        list.add(builder8.build());
        list.add(builder9.build());

        return list
    }

    fun drawOffbounds() {
        GraphicsUtil.fillRect(Vector2d(0.0, -63.0), 18.0, 18.0) // robot against the wall
    }
}

val Double.toRadians get() = (Math.toRadians(this))

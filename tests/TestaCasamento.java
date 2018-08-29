import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.parsers.RegexPrefixCapturingPatternParser;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.SilentStepMonitor;
import org.jbehave.core.steps.ParameterConverters.DateConverter;
import org.junit.Test;

public class TestaCasamento {
	
	@Test
    public void runClasspathLoadedStoriesAsJUnit() {
        Embedder embedder = new Embedder() {
        	@Override
            public EmbedderControls embedderControls() {
                return new EmbedderControls().doIgnoreFailureInStories(false).doIgnoreFailureInView(false);
            }
         
            @Override
            public Configuration configuration() {
                Class <? extends Embedder> embedderClass = this.getClass();
                return new MostUsefulConfiguration()
                    .useStoryLoader(new LoadFromClasspath())
                    .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withCodeLocation(CodeLocations.codeLocationFromClass(embedderClass))
                        .withDefaultFormats()
                        .withFormats(Format.STATS,Format.HTML, Format.CONSOLE)
                        .withCrossReference(new CrossReference()))
                    .useParameterConverters(new ParameterConverters()
                            .addConverters(new DateConverter(new SimpleDateFormat("yyyy-MM-dd")))) 
                    .useStepPatternParser(new RegexPrefixCapturingPatternParser(
                                    "$")) // to identify parameters
                    .useStepMonitor(new SilentStepMonitor());                               
            }
         
            @Override
            public InjectableStepsFactory stepsFactory() {
            	return new InstanceStepsFactory(configuration(), 
            			new TestaListaDeConvidados(),
            			new TestaMusicas());
            }
        };
        List<String> storyPaths = Arrays.asList("Convidados.story", "Musica.story");
        embedder.runStoriesAsPaths(storyPaths);
    }

}

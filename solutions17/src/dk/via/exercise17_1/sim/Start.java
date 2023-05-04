package dk.via.exercise17_1.sim;

import dk.via.exercise17_1.access.ElectionAccessManager;
import dk.via.exercise17_1.election.Election;
import dk.via.exercise17_1.voting.LocalNews;
import dk.via.exercise17_1.voting.News;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        ElectionAccessManager accessManager = new ElectionAccessManager(new Election());
        VotingSimulation votingSimulation = new VotingSimulation(accessManager);
        NewsThread news1 = new NewsThread(new News(accessManager));
        NewsThread news2 = new NewsThread(new News(accessManager));
        NewsThread hereNews = new NewsThread(new LocalNews(accessManager, "Here"));// new LocalNewsThread(accessManager, "Here");
        NewsThread thereNews = new NewsThread(new LocalNews(accessManager, "There"));
        NewsThread everywhereNews = new NewsThread(new LocalNews(accessManager, "Everywhere"));
        news1.start();
        news2.start();
        hereNews.start();
        thereNews.start();
        everywhereNews.start();
        votingSimulation.start();
        Thread.sleep(5_000);
        Election election = accessManager.requestWrite();
        try {
            election.close();
        } finally {
            accessManager.releaseWrite();
        }
    }
}

package com.kddi.android.UtaPass.sqa_espresso.common ;

import com.kddi.android.UtaPass.sqa_espresso.pages.LibraryPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.SearchPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.SettingsPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.StreamPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.AddToPlaylistPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.LibraryTab;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.ListenWithNowPlayingBar;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.LocalNowPlayingPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.NowPlayingPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.RadioNowPlayingBar;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.RadioNowPlayingPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.SearchTab;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.SongInfoPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.SongNowPlayingBar;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.StreamNowPlayingPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.StreamTab;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.AlbumsPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.ArtistsPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.MyPlayListPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.MyUtaPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.PlayHistoryPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.SongsPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.VideosPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.FavoritePage;

import com.kddi.android.UtaPass.sqa_espresso.pages.library.albums.AlbumsDetailPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.artists.ArtistAlbumsPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.artists.ArtistDetailPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.favorite.PlaylistsPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.myplaylist.AddMusicPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.myplaylist.CreatePlayListPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.myplaylist.MoreMenuPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.myplaylist.MyPlaylistDetailPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.myplaylist.addmusic.MyPlayListSongsPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.myuta.EmptyMyUtaPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.myuta.SongMoreActionMenu;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.songs.PermissionPopupMessage;
import com.kddi.android.UtaPass.sqa_espresso.pages.settings.IdSettingsPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.Best50Page;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.LiveConcertPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.NewSongsHitSongsPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.SideBarMenu;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.SpotlightPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.detail.ArtistNewReleaseDetailPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.detail.DailyMixDetailPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.detail.LiveDetailPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.detail.NewSongsHitSongsDetailPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.detail.OnAirSonglistPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.detail.PopularArtistDetailPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.detail.RadioDetailPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.detail.TopChartsDetailPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.common.DeleteMyUtaConfirmPopupMessage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.common.SaveMyUtaConfirmPopupMessage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.common.SaveMyUtaPopupMessage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.detail.WhatsNewDetailPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.page.PopularArtistPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.page.TopChartPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.page.WhatsNewPage;


public class Navigator {

    private StreamPage streamPage ;
    private LibraryPage libraryPage ;
    private SearchPage searchPage ;

    private SpotlightPage spotlightPage ;
    private LiveConcertPage liveConcertPage ;
    private Best50Page best50Page ;

    private SongsPage songsPage ;
    private AlbumsPage albumsPage ;
    private AlbumsDetailPage albumsDetailPage ;
    private ArtistsPage artistsPage ;
    private ArtistAlbumsPage artistAlbumsPage ;
    private VideosPage videosPage ;
    private FavoritePage favoritePage ;
    private PlaylistsPage playlistsPage ;

    private MyUtaPage myUtaPage ;
    private SongMoreActionMenu songMoreActionMenu ;

    private SongNowPlayingBar songNowPlayingBar ;
    private RadioNowPlayingBar radioNowPlayingBar ;
    private ListenWithNowPlayingBar listenWithNowPlayingBar ;

    private StreamTab streamTab ;
    private LibraryTab libraryTab ;
    private SearchTab searchTab ;

    private SaveMyUtaPopupMessage saveMyUtaPopupMessage ;
    private SaveMyUtaConfirmPopupMessage saveMyUtaConfirmPopupMessage ;
    private DeleteMyUtaConfirmPopupMessage deleteMyUtaConfirmPopupMessage ;

    private SideBarMenu sideBarMenu ;
    private SettingsPage settingsPage ;
    private IdSettingsPage idSettingsPage ;

    private PermissionPopupMessage permissionPopupMessage ;

    private NewSongsHitSongsPage newSongsHitSongsPage ;
    private MyPlayListPage myPlayListPage;
    private CreatePlayListPage createPlayListPage;
    private AddMusicPage addMusicPage;
    private MyPlayListSongsPage myPlaylistSongsPage;
    private TopChartsDetailPage topChartsDetailPage;
    private ArtistNewReleaseDetailPage artistNewReleaseDetailPage;
    private NewSongsHitSongsDetailPage newSongsHitSongsDetailPage;
    private PopularArtistDetailPage popularArtistDetailPage ;
    private WhatsNewDetailPage whatsNewDetailPage;
    private DailyMixDetailPage dailyMixDetailPage;
    private TopChartPage topChartPage;
    private WhatsNewPage whatsNewPage;
    private PopularArtistPage popularArtistPage;
    private NowPlayingPage nowPlayingPage;
    private PlayHistoryPage playHistoryPage;
    private LocalNowPlayingPage localNowPlayingPage;
    private StreamNowPlayingPage streamNowPlayingPage;
    private AddToPlaylistPage addToPlaylistPage;
    private MyPlaylistDetailPage myPlaylistDetailPage;
    private ArtistDetailPage artistDetailPage;
    private RadioDetailPage radioDetailPage;
    private LiveDetailPage liveDetailPage;
    private MoreMenuPage moreMenuPage;
    private OnAirSonglistPage onAriSonglistPage;
    private RadioNowPlayingPage radioNowPlayingPage;
    private SongInfoPage songInfoPage;
    private EmptyMyUtaPage emptyMyUtaPage;

    public EmptyMyUtaPage emptyMyUtaPage(){
        if( this.emptyMyUtaPage == null ){
            this.emptyMyUtaPage = new EmptyMyUtaPage();
        }
        return this.emptyMyUtaPage.ready();
    }

    public SongInfoPage songInfoPage(){
        if( this.songInfoPage == null ){
            this.songInfoPage = new SongInfoPage();
        }
        return this.songInfoPage.ready();
    }

    public RadioNowPlayingPage radioNowPlayingPage(){
        if( this.radioNowPlayingPage == null ){
            this.radioNowPlayingPage = new RadioNowPlayingPage();
        }
        return this.radioNowPlayingPage.ready();
    }

    public OnAirSonglistPage onAriSonglistPage(){
        if( this.onAriSonglistPage == null ){
            this.onAriSonglistPage = new OnAirSonglistPage();
        }
        return this.onAriSonglistPage.ready();
    }

    public MoreMenuPage moreMenuPage(){
        if( this.moreMenuPage == null ){
            this.moreMenuPage = new MoreMenuPage();
        }
        return this.moreMenuPage.ready();
    }

    public LiveDetailPage liveDetailPage(){
        if( this.liveDetailPage == null ){
            this.liveDetailPage = new LiveDetailPage();
        }
        return this.liveDetailPage.ready();
    }

    public  RadioDetailPage radioDetailPage(){
        if( this.radioDetailPage == null ){
            this.radioDetailPage = new RadioDetailPage();
        }
        return this.radioDetailPage.ready();
    }

    public ArtistDetailPage artistDetailPage(){
        if( this.artistDetailPage == null ){
            this.artistDetailPage = new ArtistDetailPage();
        }
        return this.artistDetailPage.ready();
    }

    public MyPlaylistDetailPage myPlaylistDetailPage(){
        if( this.myPlaylistDetailPage == null ){
            this.myPlaylistDetailPage = new MyPlaylistDetailPage();
        }
        return this.myPlaylistDetailPage.ready();
    }

    public AddToPlaylistPage addToPlaylistPage(){
        if( this.addToPlaylistPage == null ){
            this.addToPlaylistPage = new AddToPlaylistPage();
        }
        return this.addToPlaylistPage.ready();
    }

    public StreamNowPlayingPage streamNowPlayingPage(){
        if( this.streamNowPlayingPage == null ) {
            this.streamNowPlayingPage = new StreamNowPlayingPage() ;
        }
        return this.streamNowPlayingPage.ready() ;
    }

    public LocalNowPlayingPage localNowPlayingPage(){
        if( this.localNowPlayingPage == null ) {
            this.localNowPlayingPage = new LocalNowPlayingPage() ;
        }
        return this.localNowPlayingPage.ready() ;
    }

    public PlayHistoryPage playHistoryPage(){
        if( this.playHistoryPage == null ) {
            this.playHistoryPage = new PlayHistoryPage() ;
        }
        return this.playHistoryPage.ready() ;
    }

    public NowPlayingPage nowPlayingPage(){
        if( this.nowPlayingPage == null ) {
            this.nowPlayingPage = new NowPlayingPage() ;
        }
        return this.nowPlayingPage.ready() ;
    }

    public PopularArtistPage popularArtistPage(){
        if( this.popularArtistPage == null ) {
            this.popularArtistPage = new PopularArtistPage() ;
        }
        return this.popularArtistPage.ready() ;
    }

    public WhatsNewPage whatsNewPage(){
        if( this.whatsNewPage == null ) {
            this.whatsNewPage = new WhatsNewPage() ;
        }
        return this.whatsNewPage.ready() ;
    }

    public TopChartPage topChartPage(){
        if( this.topChartPage == null ) {
            this.topChartPage = new TopChartPage() ;
        }
        return this.topChartPage.ready() ;
    }

    public DailyMixDetailPage dailyMixDetailPage(){
        if( this.dailyMixDetailPage == null ) {
            this.dailyMixDetailPage = new DailyMixDetailPage() ;
        }
        return this.dailyMixDetailPage.ready() ;
    }

    public NewSongsHitSongsDetailPage newSongsHitSongsDetailPage(){
        if( this.newSongsHitSongsDetailPage == null ) {
            this.newSongsHitSongsDetailPage = new NewSongsHitSongsDetailPage() ;
        }
        return this.newSongsHitSongsDetailPage.ready() ;
    }

    public PopularArtistDetailPage popularArtistDetailPage(){
        if( this.popularArtistDetailPage == null ) {
            this.popularArtistDetailPage = new PopularArtistDetailPage() ;
        }
        return this.popularArtistDetailPage.ready() ;
    }

    public WhatsNewDetailPage whatsNewDetailPage(){
        if( this.whatsNewDetailPage == null ) {
            this.whatsNewDetailPage = new WhatsNewDetailPage() ;
        }
        return this.whatsNewDetailPage.ready() ;
    }

    public ArtistNewReleaseDetailPage artistNewReleaseDetailPage(){
        if( this.artistNewReleaseDetailPage == null ) {
            this.artistNewReleaseDetailPage = new ArtistNewReleaseDetailPage() ;
        }
        return this.artistNewReleaseDetailPage.ready() ;
    }

    public TopChartsDetailPage topChartsDetailPage() {
        if( this.topChartsDetailPage == null ) {
            this.topChartsDetailPage = new TopChartsDetailPage() ;
        }
        return this.topChartsDetailPage.ready() ;
    }

    public MyPlayListSongsPage myPlayListSongsPage() {
        if( this.myPlaylistSongsPage == null ) {
            this.myPlaylistSongsPage = new MyPlayListSongsPage() ;
        }
        return this.myPlaylistSongsPage.ready() ;
    }

    public MyPlayListPage myPlayListPage() {
        if( this.myPlayListPage == null ) {
            this.myPlayListPage = new MyPlayListPage() ;
        }
        return this.myPlayListPage.ready() ;
    }

    public CreatePlayListPage createPlayListPage(){
        if( this.createPlayListPage == null ) {
            this.createPlayListPage = new CreatePlayListPage() ;
        }
        return this.createPlayListPage.ready() ;
    }

    public AddMusicPage addMusicPage(){
        if( this.addMusicPage == null ) {
            this.addMusicPage = new AddMusicPage() ;
        }
        return this.addMusicPage.ready() ;
    }

    public StreamPage streamPage() {
        if( this.streamPage == null ) {
            this.streamPage = new StreamPage() ;
        }
        return this.streamPage.ready() ;
    }

    public LibraryPage libraryPage() {
        if( this.libraryPage == null ) {
            this.libraryPage = new LibraryPage() ;
        }
        return this.libraryPage.ready() ;
    }

    public SearchPage searchPage() {
        if( this.searchPage == null ) {
            this.searchPage = new SearchPage() ;
        }
        return this.searchPage.ready() ;
    }

    public SpotlightPage spotlightPage() {
        if( this.spotlightPage == null ) {
            this.spotlightPage = new SpotlightPage() ;
        }
        return this.spotlightPage.ready() ;
    }

    public LiveConcertPage liveConcertPage() {
        if( this.liveConcertPage == null ) {
            this.liveConcertPage = new LiveConcertPage() ;
        }
        return this.liveConcertPage.ready() ;
    }

    public Best50Page best50Page() {
        if( this.best50Page == null ) {
            this.best50Page = new Best50Page() ;
        }
        return this.best50Page.ready() ;
    }

    public SongsPage songsPage() {
        if( this.songsPage == null ) {
            this.songsPage = new SongsPage() ;
        }
        return this.songsPage.ready() ;
    }

    public AlbumsPage albumsPage() {
        if( this.albumsPage == null ) {
            this.albumsPage = new AlbumsPage() ;
        }
        return this.albumsPage.ready() ;
    }

    public AlbumsDetailPage albumsDetailPage() {
        if( this.albumsDetailPage == null ) {
            this.albumsDetailPage = new AlbumsDetailPage() ;
        }
        return this.albumsDetailPage.ready() ;
    }

    public ArtistsPage artistsPage() {
        if( this.artistsPage == null ) {
            this.artistsPage = new ArtistsPage() ;
        }
        return this.artistsPage.ready() ;
    }

    public ArtistAlbumsPage artistAlbumsPage() {
        if( this.artistAlbumsPage == null ) {
            this.artistAlbumsPage = new ArtistAlbumsPage() ;
        }
        return this.artistAlbumsPage.ready() ;
    }

    public MyUtaPage myUtaPage() {
        if( this.myUtaPage == null ) {
            this.myUtaPage = new MyUtaPage() ;
        }
        return this.myUtaPage.ready() ;
    }

    public SongMoreActionMenu songMoreActionMenu() {
        if( this.songMoreActionMenu == null ) {
            this.songMoreActionMenu = new SongMoreActionMenu() ;
        }
        return this.songMoreActionMenu.ready() ;
    }

    public SongNowPlayingBar songNowPlayingBar() {
        if( this.songNowPlayingBar == null ) {
            this.songNowPlayingBar = new SongNowPlayingBar() ;
        }
        return this.songNowPlayingBar.ready() ;
    }

    public RadioNowPlayingBar radioNowPlayingBar() {
        if( this.radioNowPlayingBar == null ) {
            this.radioNowPlayingBar = new RadioNowPlayingBar() ;
        }
        return this.radioNowPlayingBar.ready() ;
    }

    public ListenWithNowPlayingBar listenWithNowPlayingBar() {
        if( this.listenWithNowPlayingBar == null ) {
            this.listenWithNowPlayingBar = new ListenWithNowPlayingBar() ;
        }
        return this.listenWithNowPlayingBar ;
    }

    public StreamTab streamTab() {
        if( this.streamTab == null ) {
            this.streamTab = new StreamTab() ;
        }
        return this.streamTab.ready() ;
    }

    public LibraryTab libraryTab() {
        if( this.libraryTab == null ) {
            this.libraryTab = new LibraryTab() ;
        }
        return this.libraryTab.ready() ;
    }

    public SearchTab searchTab() {
        if( this.searchTab == null ) {
            this.searchTab = new SearchTab() ;
        }
        return this.searchTab.ready() ;
    }

    public SaveMyUtaPopupMessage saveMyUtaPopupMessage() {
        if( this.saveMyUtaPopupMessage == null ) {
            this.saveMyUtaPopupMessage = new SaveMyUtaPopupMessage() ;
        }
        return this.saveMyUtaPopupMessage.ready() ;
    }

    public SaveMyUtaConfirmPopupMessage saveMyUtaConfirmPopupMessage() {
        if( this.saveMyUtaConfirmPopupMessage == null ) {
            this.saveMyUtaConfirmPopupMessage = new SaveMyUtaConfirmPopupMessage() ;
        }

        // saveMyUtaConfirmPopupMessage only displays
        // when a user hits MyUta button on first time.
        // After that, it will not display any more.
        // Thus, it is not OK to call ready() before using it.
        return this.saveMyUtaConfirmPopupMessage ;
    }

    public DeleteMyUtaConfirmPopupMessage deleteMyUtaConfirmPopupMessage() {
        if( this.deleteMyUtaConfirmPopupMessage == null ) {
            this.deleteMyUtaConfirmPopupMessage = new DeleteMyUtaConfirmPopupMessage() ;
        }
        return this.deleteMyUtaConfirmPopupMessage.ready() ;
    }

    public SideBarMenu sideBarMenu() {
        if( this.sideBarMenu == null ) {
            this.sideBarMenu = new SideBarMenu() ;
        }
        return this.sideBarMenu.ready() ;
    }

    public SettingsPage settingsPage() {
        if( this.settingsPage == null ) {
            this.settingsPage = new SettingsPage() ;
        }
        return this.settingsPage.ready() ;
    }

    public IdSettingsPage idSettingsPage() {
        if( this.idSettingsPage == null ) {
            this.idSettingsPage = new IdSettingsPage() ;
        }
        return this.idSettingsPage ;
    }

    public PermissionPopupMessage permissionPopupMessage() {
        if( this.permissionPopupMessage == null ) {
            this.permissionPopupMessage = new PermissionPopupMessage() ;
        }
        return this.permissionPopupMessage ;
    }

    public NewSongsHitSongsPage newSongsHitSongsPage() {
        if( this.newSongsHitSongsPage == null ) {
            this.newSongsHitSongsPage = new NewSongsHitSongsPage() ;
        }
        return this.newSongsHitSongsPage.ready() ;
    }

    public VideosPage videosPage() {
        if( this.videosPage == null ) {
            this.videosPage = new VideosPage() ;
        }
        return this.videosPage.ready() ;
    }

    public FavoritePage favoritePage() {
        if( this.favoritePage == null ) {
            this.favoritePage = new FavoritePage() ;
        }
        return this.favoritePage.ready() ;
    }

    public PlaylistsPage playlistsPage() {
        if( this.playlistsPage == null ) {
            this.playlistsPage = new PlaylistsPage() ;
        }
        return this.playlistsPage.ready() ;
    }
}

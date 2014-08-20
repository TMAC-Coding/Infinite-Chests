/*  1:   */ package me.TMAC_Kratos.InfiniteChests;
/*  2:   */ 
/*  3:   */ import java.util.logging.Logger;
/*  4:   */ 
/*  5:   */ public class StackableLogger
/*  6:   */ {
/*  7:   */   protected Logger logger;
/*  8:   */   protected String prefix;
/*  9:   */   public static final String MINECRAFT_LOGGER = "Minecraft";
/* 10:   */   
/* 11:   */   public StackableLogger(String prefix)
/* 12:   */   {
/* 13:14 */     this.logger = Logger.getLogger("Minecraft");
/* 14:15 */     this.prefix = prefix;
/* 15:   */   }
/* 16:   */   
/* 17:   */   public void config(String msg)
/* 18:   */   {
/* 19:20 */     this.logger.config(this.prefix + ": " + msg);
/* 20:   */   }
/* 21:   */   
/* 22:   */   public void fine(String msg)
/* 23:   */   {
/* 24:25 */     this.logger.fine(this.prefix + ": " + msg);
/* 25:   */   }
/* 26:   */   
/* 27:   */   public void finer(String msg)
/* 28:   */   {
/* 29:30 */     this.logger.finer(this.prefix + ": " + msg);
/* 30:   */   }
/* 31:   */   
/* 32:   */   public void finest(String msg)
/* 33:   */   {
/* 34:35 */     this.logger.finest(this.prefix + ": " + msg);
/* 35:   */   }
/* 36:   */   
/* 37:   */   public void info(String msg)
/* 38:   */   {
/* 39:40 */     this.logger.info(this.prefix + ": " + msg);
/* 40:   */   }
/* 41:   */   
/* 42:   */   public void severe(String msg)
/* 43:   */   {
/* 44:45 */     this.logger.severe(this.prefix + ": " + msg);
/* 45:   */   }
/* 46:   */   
/* 47:   */   public void warning(String msg)
/* 48:   */   {
/* 49:50 */     this.logger.warning(this.prefix + ": " + msg);
/* 50:   */   }
/* 51:   */ }


/* Location:           E:\Java Plugins\infinite chests\src\
 * Qualified Name:     me.TMAC_Kratos.InfiniteChests.StackableLogger
 * JD-Core Version:    0.7.0.1
 */